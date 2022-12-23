package pe.unjfsc.daw.model.impl;

import java.util.LinkedHashSet;

import pe.unjfsc.daw.entity.CETramite;

public interface CITramite {

	
	public LinkedHashSet<CETramite> filterByType(String TIPO);
	public LinkedHashSet<CETramite> filterByEscuela(String ESCUELA);
	public LinkedHashSet<CETramite> filterByFacultad(String FACULTAD);
	public CETramite buscarTramiteByCod(String CODIGO);
	
}
