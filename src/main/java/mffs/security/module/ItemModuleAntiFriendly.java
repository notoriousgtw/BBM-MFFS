package mffs.security.module;

import com.builtbroken.mc.lib.transform.vector.Pos;
import com.builtbroken.mc.prefab.entity.damage.DamageSources;
import mffs.api.machine.IProjector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

class ItemModuleAntiFriendly extends ItemModuleDefense
{
    @Override
    public boolean onProject(IProjector projector, List<Pos> fields)
    {
        List<Entity> entities = getEntitiesInField(projector);
        entities.stream().filter(entity -> entities instanceof EntityLivingBase && !(entities instanceof IMob || entities instanceof INpc || entities instanceof EntityPlayer)).forEach(entity1 -> entity1.attackEntityFrom(DamageSources.ELECTRIC.getSource(), 100));
        return false;
    }
}