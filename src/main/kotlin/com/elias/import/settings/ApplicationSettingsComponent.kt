package com.elias.import.settings

import com.intellij.util.ui.FormBuilder
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class ApplicationSettingsComponent() {
    private val pathToSettingsInput = JTextField("");
    var settingsPanel: JPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent(JLabel("Path to settings:"), pathToSettingsInput)
        .panel

    var pathToSettings: String
        get() = pathToSettingsInput.text;
        set(text) {
            pathToSettingsInput.text = text
        }
}