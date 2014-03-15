package pl.edu.agh.colonialskirmish.game;

import android.graphics.drawable.Drawable;

public class GameCard implements Card {

	/* Title of the card */
	protected String name;

	/* Types of the card */
	protected CardType mainType;
	protected CardType secondaryType;

	/* GameCard cost in action points and special resources */
	protected int cost;
	// TODO add cost in special resources

	/* Maximum and actual health of the unit */
	protected int basicHealth;
	protected int health;

	/* Maximum and actual attack/deffense values */
	protected int basicKineticAtt;
	protected int basicKineticDef;
	protected int basicEnergyAtt;
	protected int basicEnergyDef;
	protected int basicMissleAtt;
	protected int basicMissleDef;

	protected int kineticAtt;
	protected int kineticDef;
	protected int energyAtt;
	protected int energyDef;
	protected int missleAtt;
	protected int missleDef;

	/* Specifiec if the card was used this turn */
	protected boolean isActivated;

	/* Card description */
	protected String description;

	/* Image of this card */
	protected Drawable image;
	protected String imagePath = "spaceship.jpg";

	@Override
	public void getInitAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnPlayAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnActivateAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnDiscardAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnRemoveAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnPlayerDrawsCardsAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnEnemyDrawsCardsAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnReceiveDamageAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnNewTurnAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnCardDiscardedAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnCardRemovedAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnEnemyUnitDestroyedAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOnFriendlyUnitDestroyedAction() {
		// TODO Auto-generated method stub

	}

	/***** Getters and setters *****/

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public CardType getMainType() {
		return mainType;
	}

	public void setMainType( CardType mainType ) {
		this.mainType = mainType;
	}

	public CardType getSecondaryType() {
		return secondaryType;
	}

	public void setSecondaryType( CardType secondaryType ) {
		this.secondaryType = secondaryType;
	}

	public int getCost() {
		return cost;
	}

	public void setCost( int cost ) {
		this.cost = cost;
	}

	public int getBasicHealth() {
		return basicHealth;
	}

	public void setBasicHealth( int basicHealth ) {
		this.basicHealth = basicHealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth( int health ) {
		this.health = health;
	}

	public int getBasicKineticAtt() {
		return basicKineticAtt;
	}

	public void setBasicKineticAtt( int basicKineticAtt ) {
		this.basicKineticAtt = basicKineticAtt;
	}

	public int getBasicKineticDef() {
		return basicKineticDef;
	}

	public void setBasicKineticDef( int basicKineticDef ) {
		this.basicKineticDef = basicKineticDef;
	}

	public int getBasicEnergyAtt() {
		return basicEnergyAtt;
	}

	public void setBasicEnergyAtt( int basicEnergyAtt ) {
		this.basicEnergyAtt = basicEnergyAtt;
	}

	public int getBasicEnergyDef() {
		return basicEnergyDef;
	}

	public void setBasicEnergyDef( int basicEnergyDef ) {
		this.basicEnergyDef = basicEnergyDef;
	}

	public int getBasicMissleAtt() {
		return basicMissleAtt;
	}

	public void setBasicMissleAtt( int basicMissleAtt ) {
		this.basicMissleAtt = basicMissleAtt;
	}

	public int getBasicMissleDef() {
		return basicMissleDef;
	}

	public void setBasicMissleDef( int basicMissleDef ) {
		this.basicMissleDef = basicMissleDef;
	}

	public int getKineticAtt() {
		return kineticAtt;
	}

	public void setKineticAtt( int kineticAtt ) {
		this.kineticAtt = kineticAtt;
	}

	public int getKineticDef() {
		return kineticDef;
	}

	public void setKineticDef( int kineticDef ) {
		this.kineticDef = kineticDef;
	}

	public int getEnergyAtt() {
		return energyAtt;
	}

	public void setEnergyAtt( int energyAtt ) {
		this.energyAtt = energyAtt;
	}

	public int getEnergyDef() {
		return energyDef;
	}

	public void setEnergyDef( int energyDef ) {
		this.energyDef = energyDef;
	}

	public int getMissleAtt() {
		return missleAtt;
	}

	public void setMissleAtt( int missleAtt ) {
		this.missleAtt = missleAtt;
	}

	public int getMissleDef() {
		return missleDef;
	}

	public void setMissleDef( int missleDef ) {
		this.missleDef = missleDef;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated( boolean isActivated ) {
		this.isActivated = isActivated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public Drawable getImage() {
		return image;
	}

	public void setImage( Drawable image ) {
		this.image = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath( String imagePath ) {
		this.imagePath = imagePath;
	}

}
