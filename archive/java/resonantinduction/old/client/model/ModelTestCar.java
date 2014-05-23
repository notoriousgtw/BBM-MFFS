// Date: 11/10/2013 11:17:40 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package resonantinduction.old.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTestCar extends ModelBase
{
	// fields
	ModelRenderer base;
	ModelRenderer base2;
	ModelRenderer seat;
	ModelRenderer seatback;
	ModelRenderer engineWall;
	ModelRenderer dash;
	ModelRenderer body;
	ModelRenderer body2;
	ModelRenderer body3;
	ModelRenderer headlight;
	ModelRenderer box;
	ModelRenderer boxLid;
	ModelRenderer frontRightAxil;
	ModelRenderer frontRightWheel;
	ModelRenderer frontLefttAxil;
	ModelRenderer frontLeftWheel;
	ModelRenderer backRightAxil;
	ModelRenderer backRightWheel;
	ModelRenderer backleftAxil;
	ModelRenderer backLeftWheel;

	public ModelTestCar()
	{
		textureWidth = 128;
		textureHeight = 128;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 14, 2, 25);
		base.setRotationPoint(-7F, 22F, -8F);
		base.setTextureSize(128, 128);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		base2 = new ModelRenderer(this, 0, 0);
		base2.addBox(0F, 0F, 0F, 12, 2, 33);
		base2.setRotationPoint(-6F, 24F, -18F);
		base2.setTextureSize(128, 128);
		base2.mirror = true;
		setRotation(base2, 0F, 0F, 0F);
		seat = new ModelRenderer(this, 2, 73);
		seat.addBox(0F, 0F, 0F, 14, 2, 10);
		seat.setRotationPoint(-7F, 20F, -3F);
		seat.setTextureSize(128, 128);
		seat.mirror = true;
		setRotation(seat, 0F, 0F, 0F);
		seatback = new ModelRenderer(this, 2, 88);
		seatback.addBox(0F, 0F, 0F, 14, 2, 10);
		seatback.setRotationPoint(-7F, 20F, 5F);
		seatback.setTextureSize(128, 128);
		seatback.mirror = true;
		setRotation(seatback, 1.448623F, 0F, 0F);
		engineWall = new ModelRenderer(this, 80, 116);
		engineWall.addBox(0F, 0F, 0F, 16, 6, 2);
		engineWall.setRotationPoint(-8F, 13F, -8F);
		engineWall.setTextureSize(128, 128);
		engineWall.mirror = true;
		setRotation(engineWall, -0.1570796F, 0F, 0F);
		dash = new ModelRenderer(this, 80, 68);
		dash.addBox(0F, 0F, 0F, 16, 4, 2);
		dash.setRotationPoint(-8F, 10F, -9F);
		dash.setTextureSize(128, 128);
		dash.mirror = true;
		setRotation(dash, 0.2617994F, 0F, 0F);
		body = new ModelRenderer(this, 70, 77);
		body.addBox(0F, 0F, 0F, 16, 9, 2);
		body.setRotationPoint(-8F, 10F, -17F);
		body.setTextureSize(128, 128);
		body.mirror = true;
		setRotation(body, -0.2268928F, 0F, 0F);
		body2 = new ModelRenderer(this, 0, 0);
		body2.addBox(0F, 0F, 0F, 14, 6, 12);
		body2.setRotationPoint(-7F, 18F, -19F);
		body2.setTextureSize(128, 128);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		body3 = new ModelRenderer(this, 70, 90);
		body3.addBox(0F, 0F, 0F, 16, 9, 10);
		body3.setRotationPoint(-8F, 10F, -17F);
		body3.setTextureSize(128, 128);
		body3.mirror = true;
		setRotation(body3, 0F, 0F, 0F);
		headlight = new ModelRenderer(this, 0, 120);
		headlight.addBox(-2F, -2F, -3F, 4, 4, 3);
		headlight.setRotationPoint(0F, 19F, -17F);
		headlight.setTextureSize(128, 128);
		headlight.mirror = true;
		setRotation(headlight, 0F, 0F, 0F);
		box = new ModelRenderer(this, 0, 43);
		box.addBox(0F, 0F, 0F, 14, 7, 9);
		box.setRotationPoint(-7F, 15F, 9F);
		box.setTextureSize(128, 128);
		box.mirror = true;
		setRotation(box, 0F, 0F, 0F);
		boxLid = new ModelRenderer(this, 47, 43);
		boxLid.addBox(0F, -2F, 0F, 14, 2, 9);
		boxLid.setRotationPoint(-7F, 15F, 9F);
		boxLid.setTextureSize(128, 128);
		boxLid.mirror = true;
		setRotation(boxLid, 0.0872665F, 0F, 0F);
		frontRightAxil = new ModelRenderer(this, 0, 110);
		frontRightAxil.addBox(-1F, -1F, -1F, 1, 2, 2);
		frontRightAxil.setRotationPoint(-7F, 23F, -12F);
		frontRightAxil.setTextureSize(128, 128);
		frontRightAxil.mirror = true;
		setRotation(frontRightAxil, 0F, 0F, 0F);
		frontRightWheel = new ModelRenderer(this, 60, 60);
		frontRightWheel.addBox(-1F, -3F, -3F, 2, 6, 6);
		frontRightWheel.setRotationPoint(-9F, 23F, -12F);
		frontRightWheel.setTextureSize(128, 128);
		frontRightWheel.mirror = true;
		setRotation(frontRightWheel, 0F, 0F, 0F);
		frontLefttAxil = new ModelRenderer(this, 0, 110);
		frontLefttAxil.addBox(0F, -1F, -1F, 1, 2, 2);
		frontLefttAxil.setRotationPoint(7F, 23F, -12F);
		frontLefttAxil.setTextureSize(128, 128);
		frontLefttAxil.mirror = true;
		setRotation(frontLefttAxil, 0F, 0F, 0F);
		frontLeftWheel = new ModelRenderer(this, 60, 60);
		frontLeftWheel.addBox(-1F, -3F, -3F, 2, 6, 6);
		frontLeftWheel.setRotationPoint(9F, 23F, -12F);
		frontLeftWheel.setTextureSize(128, 128);
		frontLeftWheel.mirror = true;
		setRotation(frontLeftWheel, 0F, 0F, 0F);
		backRightAxil = new ModelRenderer(this, 0, 110);
		backRightAxil.addBox(-1F, -1F, -1F, 1, 2, 2);
		backRightAxil.setRotationPoint(-7F, 23F, 11F);
		backRightAxil.setTextureSize(128, 128);
		backRightAxil.mirror = true;
		setRotation(backRightAxil, 0F, 0F, 0F);
		backRightWheel = new ModelRenderer(this, 60, 60);
		backRightWheel.addBox(-1F, -3F, -3F, 2, 6, 6);
		backRightWheel.setRotationPoint(-9F, 23F, 11F);
		backRightWheel.setTextureSize(128, 128);
		backRightWheel.mirror = true;
		setRotation(backRightWheel, 0F, 0F, 0F);
		backleftAxil = new ModelRenderer(this, 110, 0);
		backleftAxil.addBox(0F, -1F, -1F, 1, 2, 2);
		backleftAxil.setRotationPoint(7F, 23F, 11F);
		backleftAxil.setTextureSize(128, 128);
		backleftAxil.mirror = true;
		setRotation(backleftAxil, 0F, 0F, 0F);
		backLeftWheel = new ModelRenderer(this, 60, 60);
		backLeftWheel.addBox(-1F, -3F, -3F, 2, 6, 6);
		backLeftWheel.setRotationPoint(9F, 23F, 11F);
		backLeftWheel.setTextureSize(128, 128);
		backLeftWheel.mirror = true;
		setRotation(backLeftWheel, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		base.render(f5);
		base2.render(f5);
		seat.render(f5);
		seatback.render(f5);
		engineWall.render(f5);
		dash.render(f5);
		body.render(f5);
		body2.render(f5);
		body3.render(f5);
		headlight.render(f5);
		box.render(f5);
		boxLid.render(f5);
		frontRightAxil.render(f5);
		frontRightWheel.render(f5);
		frontLefttAxil.render(f5);
		frontLeftWheel.render(f5);
		backRightAxil.render(f5);
		backRightWheel.render(f5);
		backleftAxil.render(f5);
		backLeftWheel.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}