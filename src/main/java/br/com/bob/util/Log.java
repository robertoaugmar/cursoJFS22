package br.com.bob.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Log implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -537195600028835441L;

	
	public void afterPhase(PhaseEvent arg0) {
		
		
	}

	
	public void beforePhase(PhaseEvent event) {
		
		System.err.println("FASE: " + event.getPhaseId());
	}

	
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}

}
