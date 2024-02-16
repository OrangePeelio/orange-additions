package orangepeel.orangeadditions.mixins.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.input.PlayerInput;
import net.minecraft.client.option.GameSettings;
import net.minecraft.core.data.gamerule.GameRule;
import net.minecraft.core.data.gamerule.GameRuleBoolean;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.entity.player.EntityPlayer;
import orangepeel.orangeadditions.OrangeAdditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerInput.class, remap = false)
public class PlayerInputMixin {
	private int sprintTime = 20;
	private boolean pressedSprint = false;
	@Shadow
	@Final
	private GameSettings gameSettings;
	@Shadow
	private boolean pressedForward;
	@Shadow
	@Final
	public Minecraft mc;

	@Inject(method = "tick", at = @At(value = "TAIL"))
	public void tick(EntityPlayer entityplayer, CallbackInfo ci) {
		if(entityplayer.inventory.armorItemInSlot(1) != null){
			if (entityplayer.inventory.armorItemInSlot(1).getItem().equals(OrangeAdditions.speedBoosters) && !entityplayer.isSneaking()) {
				return;
			}
		}

			entityplayer.setSprinting(false);
	}

}
