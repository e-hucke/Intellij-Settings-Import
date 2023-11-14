package com.elias.import.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class ApplicationSettingsConfigurable: Configurable {
    private var appSettingsComponent: ApplicationSettingsComponent? = null
    override fun createComponent(): JComponent? {
        appSettingsComponent = ApplicationSettingsComponent();
        return appSettingsComponent?.settingsPanel;
    }

    override fun isModified(): Boolean {
        val settings = ApplicationSettingsState.instance;
        return !appSettingsComponent!!.pathToSettings.equals(settings.pathToFiles);
    }

    override fun apply() {
        val settings = ApplicationSettingsState.instance;
        settings.pathToFiles = appSettingsComponent!!.pathToSettings;
    }

    override fun getDisplayName(): String {
        return "Import Settings Plugin"
    }
}