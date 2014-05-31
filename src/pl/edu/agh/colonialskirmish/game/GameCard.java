package pl.edu.agh.colonialskirmish.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GameCard implements Card, Serializable {

	static AtomicInteger GAME_CARD_ID_COUNTER = new AtomicInteger();

	protected int inGameId; // card instance id
	protected int id; // card type id
	protected int version = 0;

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
	protected String imagePath = "spaceship.jpg";

	protected List<CardAction> cardActionList = new ArrayList<CardAction>();

	protected String initAction;
	protected String onPlayAction = "gameLog.append('BOOM!')";
	protected String onActivateAction;
	protected String onDiscardAction;
	protected String onRemoveAction;
	protected String onPlayerDrawsCardsAction;
	protected String onEnemyDrawsCardsAction;
	protected String onReceiveDamageAction;
	protected String onNewTurnAction;
	protected String onCardDiscardedAction;
	protected String onCardRemovedAction;
	protected String onEnemyUnitDestroyedAction;
	protected String onFriendlyUnitDestroyedAction;
	protected String onActionUsedAction;

	protected CardLocation cardLocation = CardLocation.HAND;

	public GameCard() {
		inGameId = GAME_CARD_ID_COUNTER.incrementAndGet();
	}

	@Override
	public String getInitAction() {
		return initAction;
	}

	@Override
	public String getOnPlayAction() {
		return onPlayAction;
	}

	@Override
	public String getOnActivateAction() {
		return onActivateAction;
	}

	@Override
	public String getOnDiscardAction() {
		return onDiscardAction;
	}

	@Override
	public String getOnRemoveAction() {
		return onRemoveAction;
	}

	@Override
	public String getOnPlayerDrawsCardsAction() {
		return onPlayerDrawsCardsAction;
	}

	@Override
	public String getOnEnemyDrawsCardsAction() {
		return onEnemyDrawsCardsAction;
	}

	@Override
	public String getOnReceiveDamageAction() {
		return onReceiveDamageAction;
	}

	@Override
	public String getOnNewTurnAction() {
		return onNewTurnAction;
	}

	@Override
	public String getOnCardDiscardedAction() {
		return onCardDiscardedAction;
	}

	@Override
	public String getOnCardRemovedAction() {
		return onCardRemovedAction;
	}

	@Override
	public String getOnEnemyUnitDestroyedAction() {
		return onEnemyUnitDestroyedAction;
	}

	@Override
	public String getOnFriendlyUnitDestroyedAction() {
		return onFriendlyUnitDestroyedAction;
	}

	@Override
	public String getOnActionUsedAction() {
		return onActionUsedAction;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath( String imagePath ) {
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion( int version ) {
		this.version = version;
	}

	public List<CardAction> getCardActionList() {
		return cardActionList;
	}

	public void setCardActionList( List<CardAction> cardActionList ) {
		this.cardActionList = cardActionList;
	}

	public int getInGameId() {
		return inGameId;
	}

	public void setInGameId( int inGameId ) {
		this.inGameId = inGameId;
	}

	public CardLocation getCardLocation() {
		return cardLocation;
	}

	public void setCardLocation( CardLocation cardLocation ) {
		this.cardLocation = cardLocation;
	}

	public void setOnActionUsedAction( String onActionUsedAction ) {
		this.onActionUsedAction = onActionUsedAction;
	}

	@Override
	public String toString() {
		return "GameCard [id=" + id + ", version=" + version + ",inGameId=" + inGameId + " ,name="
				+ name + ", mainType=" + mainType + ", secondaryType=" + secondaryType + ", cost="
				+ cost + ", basicHealth=" + basicHealth + ", health=" + health
				+ ", basicKineticAtt=" + basicKineticAtt + ", basicKineticDef=" + basicKineticDef
				+ ", basicEnergyAtt=" + basicEnergyAtt + ", basicEnergyDef=" + basicEnergyDef
				+ ", basicMissleAtt=" + basicMissleAtt + ", basicMissleDef=" + basicMissleDef
				+ ", kineticAtt=" + kineticAtt + ", kineticDef=" + kineticDef + ", energyAtt="
				+ energyAtt + ", energyDef=" + energyDef + ", missleAtt=" + missleAtt
				+ ", missleDef=" + missleDef + ", isActivated=" + isActivated + ", description="
				+ description + ", imagePath=" + imagePath + "]";
	}

}
