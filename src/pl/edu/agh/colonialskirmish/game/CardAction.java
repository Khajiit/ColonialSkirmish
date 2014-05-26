package pl.edu.agh.colonialskirmish.game;

/**
 * Class contains description of cards special actions
 * 
 * @author Khajiit
 * 
 */
public class CardAction {

	protected String actionName;

	protected String actionDescription;

	public CardAction( String actionName, String actionDescription ) {
		super();
		this.actionName = actionName;
		this.actionDescription = actionDescription;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName( String actionName ) {
		this.actionName = actionName;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription( String actionDescription ) {
		this.actionDescription = actionDescription;
	}

}