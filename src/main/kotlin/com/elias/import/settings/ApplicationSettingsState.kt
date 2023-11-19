package com.elias.import.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.eliashucke.plugin.importsettings.settings",
    storages = [Storage("ImportSettings.xml")]
)
class ApplicationSettingsState private constructor() : PersistentStateComponent<ApplicationSettingsState> {
    var pathToFiles: String = "";


    companion object {
        val instance: ApplicationSettingsState
            get() = ApplicationManager.getApplication().getService(ApplicationSettingsState::class.java)
    }
    override fun getState(): ApplicationSettingsState {
        return this
    }



    override fun loadState(state: ApplicationSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

}