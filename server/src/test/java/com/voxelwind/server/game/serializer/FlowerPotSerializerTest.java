package com.voxelwind.server.game.serializer;

import com.flowpowered.nbt.CompoundTag;
import com.voxelwind.api.game.level.block.*;
import com.voxelwind.server.game.level.blockentities.VoxelwindFlowerpotBlockEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowerPotSerializerTest extends SerializerTestBase {
    @Test
    public void checkNBTOutput() throws Exception {
        VoxelwindFlowerpotBlockEntity voxelwindFlowerpotBlockEntity = new VoxelwindFlowerpotBlockEntity(
                FlowerType.ACACIA_SAPLING
        );

        CompoundTag tag = MetadataSerializer.serializeNBT(generateTestBlock(BlockTypes.FLOWER_POT, voxelwindFlowerpotBlockEntity));

        assertNotNull(tag);
        assertTrue(tag.getValue().containsKey("contents"));
        assertEquals(tag.getValue().get("contents").getValue(), "acacia_sapling");
    }
}