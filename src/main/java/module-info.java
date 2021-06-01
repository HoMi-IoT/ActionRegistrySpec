module org.homi.plugins.actionRegistry.specification {
	requires org.homi.plugin.specification;
	requires org.homi.plugin.api;
	
	exports org.homi.plugins.ar.specification;
	exports org.homi.plugins.ar.specification.actions;
	exports org.homi.plugins.ar.specification.actions.arguments;
	exports org.homi.plugins.ar.specification.actions.plugin
		to org.homi.plugins.actionRegistry.plugin; 
}