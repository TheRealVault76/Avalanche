package net.vault.avalanche.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.vault.avalanche.block.enums.QuadBlockFlat;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SuperCombinationStationBlock extends Block {
    public static final EnumProperty<QuadBlockFlat> PART = EnumProperty.of("part", QuadBlockFlat.class);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final VoxelShape PART1 = VoxelShapes.union(
            createCuboidShape(0, 8, 0, 16, 16, 16),
            createCuboidShape(8, 0, 8, 16, 8, 16)
    );
    private static final VoxelShape PART2 = VoxelShapes.union(
            createCuboidShape(0, 8, 0, 16, 16, 16),
            createCuboidShape(8, 0, 8, 16, 8, 16)
    );
    private static final VoxelShape PART3 = VoxelShapes.union(
            createCuboidShape(0, 8, 0, 16, 16, 16),
            createCuboidShape(8, 0, 8, 16, 8, 16)
    );
    private static final VoxelShape PART4 = VoxelShapes.union(
            createCuboidShape(0, 8, 0, 16, 16, 16),
            createCuboidShape(8, 0, 8, 16, 8, 16)
    );
    // change these
    private static final VoxelShape NORTH_SHAPE = createCuboidShape(0, 0, 0, 16, 16, 16);
    private static final VoxelShape EAST_SHAPE = createCuboidShape(0, 0, 0, 16, 16, 16);
    private static final VoxelShape SOUTH_SHAPE = createCuboidShape(0, 0, 0, 16, 16, 16);
    private static final VoxelShape WEST_SHAPE = createCuboidShape(0, 0, 0, 16, 16, 16);


    public SuperCombinationStationBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);

        return switch (direction) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> VoxelShapes.empty(); // Default case to avoid issues if direction is not handled
        };
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        Direction facing = state.get(FACING);

        // Determine positions for the adjacent blocks
        List<BlockPos> partPositions = getPartPositions(pos, facing);

        // Place each part in its respective position
        world.setBlockState(partPositions.get(0), this.getDefaultState().with(PART, QuadBlockFlat.PART1).with(FACING, facing));
        world.setBlockState(partPositions.get(1), this.getDefaultState().with(PART, QuadBlockFlat.PART2).with(FACING, facing));
        world.setBlockState(partPositions.get(2), this.getDefaultState().with(PART, QuadBlockFlat.PART3).with(FACING, facing));
        world.setBlockState(partPositions.get(3), this.getDefaultState().with(PART, QuadBlockFlat.PART4).with(FACING, facing));
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        Direction direction = ctx.getHorizontalPlayerFacing();
        List<BlockPos> partPositions = getPartPositions(blockPos, direction);
        if (blockPos.getY() >= world.getTopY() - 1 ||
                partPositions.stream().anyMatch(partPos ->
                        !world.getWorldBorder().contains(partPos) || !world.getBlockState(partPos).canReplace(ctx)
                )
        ) {
            return null;
        }
        return this.getDefaultState().with(FACING, direction).with(PART, QuadBlockFlat.PART1);
    }

    private List<BlockPos> getPartPositions(BlockPos pos, Direction facing) {

        return List.of(
                pos.offset(facing).offset(facing.rotateYCounterclockwise()),
                pos.offset(facing),
                pos,
                pos.offset(facing.rotateYCounterclockwise())
        );
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    /*@Override
    @SuppressWarnings("deprecation")
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        if (!world.isClient()) {
            Direction facing = state.get(FACING);
            List<BlockPos> partPositions = getPartPositions(pos, facing);
            
            if (partPositions.stream().anyMatch(partPos -> !world.getBlockState(partPos).isOf(this))) {
                for (BlockPos partPosition : partPositions) {
                    world.setBlockState(partPosition, Blocks.IRON_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
                }
            }
        }
    }*/
}