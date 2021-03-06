package com.entropicdreams.darva.handlers;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;

import com.entropicdreams.darva.Allomancy;
import com.entropicdreams.darva.AllomancyData;
import com.entropicdreams.darva.particles.ParticleMetal;
import com.entropicdreams.darva.util.vector3;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler implements ITickHandler {
	private final Minecraft mc;
	private ResourceLocation meterLoc;
	private AllomancyData data;
	private int animationCounter = 0;
	private int currentFrame = 0;

	private Point[] Frames = { new Point(72, 0), new Point(72, 4),
			new Point(72, 8), new Point(72, 12) };

	public RenderHandler() {
		this.mc = Minecraft.getMinecraft();
		this.meterLoc = new ResourceLocation("allomancy",
				"textures/overlay/meter.png");

	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		ParticleMetal particle;
		if (!Minecraft.getMinecraft().inGameHasFocus) {
			return;
		}
		if (FMLClientHandler.instance().getClient().currentScreen != null) {
			return;
		}
		EntityClientPlayerMP player;
		player = this.mc.thePlayer;
		if (player == null) {
			return;
		}

		this.animationCounter++;

		this.data = AllomancyData.forPlayer(player);
		// left hand side.
		int ironY, steelY, tinY, pewterY;
		// right hand side
		int copperY, bronzeY, zincY, brassY;
		if (!data.isMistborn) {
			return;
		}
		GuiIngame gig = new GuiIngame(Minecraft.getMinecraft());
		Minecraft.getMinecraft().renderEngine.bindTexture(this.meterLoc);
		TextureObject obj;
		obj = Minecraft.getMinecraft().renderEngine.getTexture(this.meterLoc);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, obj.getGlTextureId());

		switch (this.data.getSelected()) {
		case 0:
			break;
		case 1:
			gig.drawTexturedModalRect(3, 13, 54, 0, 16, 24);
			break;
		case 2:
			gig.drawTexturedModalRect(28, 13, 54, 0, 16, 24);
			break;
		case 3:
			gig.drawTexturedModalRect(53, 13, 54, 0, 16, 24);
			break;
		case 4:
			gig.drawTexturedModalRect(78, 13, 54, 0, 16, 24);
			break;

		}

		ironY = 9 - this.data.MetalAmounts[AllomancyData.matIron];
		gig.drawTexturedModalRect(6, 20 + ironY, 7, 1 + ironY, 3, 10 - ironY);

		steelY = 9 - this.data.MetalAmounts[AllomancyData.matSteel];
		gig.drawTexturedModalRect(13, 20 + steelY, 13, 1 + steelY, 3,
				10 - steelY);

		tinY = 9 - this.data.MetalAmounts[AllomancyData.matTin];
		gig.drawTexturedModalRect(31, 20 + tinY, 19, 1 + tinY, 3, 10 - tinY);

		pewterY = 9 - this.data.MetalAmounts[AllomancyData.matPewter];
		gig.drawTexturedModalRect(38, 20 + pewterY, 25, 1 + pewterY, 3,
				10 - pewterY);

		copperY = 9 - this.data.MetalAmounts[AllomancyData.matCopper];
		gig.drawTexturedModalRect(56, 20 + copperY, 31, 1 + copperY, 3,
				10 - copperY);

		bronzeY = 9 - this.data.MetalAmounts[AllomancyData.matBronze];
		gig.drawTexturedModalRect(63, 20 + bronzeY, 37, 1 + bronzeY, 3,
				10 - bronzeY);

		zincY = 9 - this.data.MetalAmounts[AllomancyData.matZinc];
		gig.drawTexturedModalRect(81, 20 + zincY, 43, 1 + zincY, 3, 10 - zincY);

		brassY = 9 - this.data.MetalAmounts[AllomancyData.matBrass];
		gig.drawTexturedModalRect(88, 20 + brassY, 49, 1 + brassY, 3,
				10 - brassY);

		// Draw the gauges second, so that highlights and decorations show
		// over
		// the bar.
		gig.drawTexturedModalRect(5, 15, 0, 0, 5, 20);
		gig.drawTexturedModalRect(12, 15, 0, 0, 5, 20);

		gig.drawTexturedModalRect(30, 15, 0, 0, 5, 20);
		gig.drawTexturedModalRect(37, 15, 0, 0, 5, 20);

		gig.drawTexturedModalRect(55, 15, 0, 0, 5, 20);
		gig.drawTexturedModalRect(62, 15, 0, 0, 5, 20);

		gig.drawTexturedModalRect(80, 15, 0, 0, 5, 20);
		gig.drawTexturedModalRect(87, 15, 0, 0, 5, 20);

		if (this.data.MetalBurning[AllomancyData.matIron]) {
			gig.drawTexturedModalRect(5, 20 + ironY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matSteel]) {
			gig.drawTexturedModalRect(12, 20 + steelY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matTin]) {
			gig.drawTexturedModalRect(30, 20 + tinY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matPewter]) {
			gig.drawTexturedModalRect(37, 20 + pewterY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matCopper]) {
			gig.drawTexturedModalRect(55, 20 + copperY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matBronze]) {
			gig.drawTexturedModalRect(62, 20 + bronzeY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matZinc]) {
			gig.drawTexturedModalRect(80, 20 + zincY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}
		if (this.data.MetalBurning[AllomancyData.matBrass]) {
			gig.drawTexturedModalRect(87, 20 + brassY,
					this.Frames[this.currentFrame].getX(),
					this.Frames[this.currentFrame].getY(), 5, 3);
		}

		if (this.animationCounter > 6) // Draw the burning symbols...
		{
			this.animationCounter = 0;
			this.currentFrame++;
			if (this.currentFrame > 3) {
				this.currentFrame = 0;
			}
		}
		double motionX, motionY, motionZ;
		for (Entity entity : Allomancy.MPC.particleTargets) {
			motionX = ((player.posX - entity.posX) * -1) * .03;
			motionY = ((player.posY - entity.posY) * -1) * .03;
			motionZ = ((player.posZ - entity.posZ) * -1) * .03;
			particle = new ParticleMetal(player.worldObj,
					player.posX
							- (Math.sin(Math.toRadians(player
									.getRotationYawHead())) * .7d),
					player.posY - .7, player.posZ
							+ (Math.cos(Math.toRadians(player
									.getRotationYawHead())) * .7d), motionX,
					motionY, motionZ);
			Minecraft.getMinecraft().effectRenderer.addEffect(particle);
		}
		for (vector3 v : Allomancy.MPC.particleBlockTargets) {
			motionX = ((player.posX - v.X) * -1) * .03;
			motionY = ((player.posY - v.Y) * -1) * .03;
			motionZ = ((player.posZ - v.Z) * -1) * .03;
			particle = new ParticleMetal(player.worldObj,
					player.posX
							- (Math.sin(Math.toRadians(player
									.getRotationYawHead())) * .7d),
					player.posY - .7, player.posZ
							+ (Math.cos(Math.toRadians(player
									.getRotationYawHead())) * .7d), motionX,
					motionY, motionZ);
			Minecraft.getMinecraft().effectRenderer.addEffect(particle);
		}
		Allomancy.MPC.particleBlockTargets.clear();
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "renderHandler";
	}

}
