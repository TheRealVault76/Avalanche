package net.vault.avalanche.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.vault.avalanche.block.enums.QuadBlockFlat;

public class SuperCombinationStationBlock extends Block {
    public static final EnumProperty<QuadBlockFlat> PART = EnumProperty.of("part", QuadBlockFlat.class);
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final VoxelShape PART1 = VoxelShapes.union(createCuboidShape(0, 8, 0, 16, 16, 16),createCuboidShape(8, 0, 8, 16, 8, 16));;
    private static final VoxelShape PART2 = VoxelShapes.union(createCuboidShape(0, 8, 0, 16, 16, 16),createCuboidShape(8, 0, 8, 16, 8, 16));;
    private static final VoxelShape PART3 = VoxelShapes.union(createCuboidShape(0, 8, 0, 16, 16, 16),createCuboidShape(8, 0, 8, 16, 8, 16));;
    private static final VoxelShape PART4 = VoxelShapes.union(createCuboidShape(0, 8, 0, 16, 16, 16),createCuboidShape(8, 0, 8, 16, 8, 16));;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;


    public SuperCombinationStationBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);

        switch (direction) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case EAST:
                return EAST_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return VoxelShapes.empty(); // Default case to avoid issues if direction is not handled
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, PlayerEntity placer, ItemPlacementContext context) {
        super.onPlaced(world, pos, state, placer, context);

        Direction facing = state.get(FACING);

        // Determine positions for the adjacent blocks
        BlockPos[] partPositions = getPartPositions(pos, facing);

        // Place each part in its respective position
        placePart(world, partPositions[0], PART);
        placePart(world, partPositions[1], PART);
        placePart(world, partPositions[2], PART);
        placePart(world, partPositions[3], PART);

        // Consume the item if not in client-side
        if (!world.isClient) {
            placer.getStackInHand(context.getHand()).decrement(1);
        }
    }

    private BlockPos[] getPartPositions(BlockPos pos, Direction facing) {
        // Define positions relative to the main block based on facing direction
        BlockPos[] positions = new BlockPos[4];
        positions[0] = pos.offset(facing.getOpposite()); // Block behind
        positions[1] = pos.offset(facing).offset(Direction.SOUTH); // Block above
        positions[2] = pos.offset(facing).offset(Direction.NORTH ); // Block to the left
        positions[3] = pos.offset(facing).offset(Direction.SOUTH).offset(Direction.WEST); // Block above and to the left
        return positions;
    }

    private void placePart(WorldAccess world, BlockPos pos, Block partBlock) {
        if (world.isAir(pos)) {
            world.setBlockState(pos, partBlock.getDefaultState();
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        // Check if a neighboring block was updated and if it might affect the block's parts
        if (!world.isClient()) {
            Direction facing = state.get(FACING);
            BlockPos[] partPositions = getPartPositions(pos, facing);

            // Remove all parts if any part's neighbor is updated
            for (BlockPos partPos : partPositions) {
                if (neighborPos.equals(partPos)) {
                    for (BlockPos position : partPositions) {
                        world.setBlockState(position, Blocks.AIR.getDefaultState();
                    }
                    break;
                }
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}

/*
This is 1 block, with 4 parts. It should be possible to define the entire block in just one class.
The block models are already in the files.
The block takes up a 2*1*2 area, and can rotate based on the direction the player is facing.
The block looks like this:
    SCS 3 | SCS 4
    SCS 2 | SCS 1
Being only one block tall, this can be presented in 2D.
You do not need to define the block entity aspect yet, just the actual block itself.
*/