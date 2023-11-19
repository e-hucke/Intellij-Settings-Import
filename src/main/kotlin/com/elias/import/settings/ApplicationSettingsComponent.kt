package com.elias.import.settings

import com.intellij.ide.DataManager
import com.intellij.openapi.actionSystem.PlatformCoreDataKeys
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.util.ui.FormBuilder
import javax.swing.Box
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField

class ApplicationSettingsComponent() {
    private val pathToSettingsInput = JTextField("",2);
    private val testButton = JButton("Choose Path");
    var settingsPanel: JPanel;

    init {
        val settings = ApplicationSettingsState.instance;
        pathToSettingsInput.text = settings.pathToFiles;
        pathToSettingsInput.isEnabled = false;
        testButton.addActionListener { browseFiles() }
        val box = Box.createHorizontalBox()
        box.add(pathToSettingsInput);
        box.add(testButton);
        settingsPanel =  FormBuilder.createFormBuilder()
            .addComponent(box)
            .panel
    }

    private fun browseFiles() {
        val dataContext = DataManager.getInstance().dataContextFromFocusAsync.blockingGet(2000)
        val project = dataContext?.getData(PlatformCoreDataKeys.PROJECT);
        val localFile = LocalFileSystem.getInstance().findFileByPath(pathToSettings);
        val descriptor =  FileChooserDescriptor(false,true,false,false,false,false);
        descriptor.isHideIgnored = false;
        val file = FileChooser.chooseFile(descriptor,project,localFile);
        if (file != null) {
            pathToSettings = file.path
        };
    }

    var pathToSettings: String
        get() = pathToSettingsInput.text;
        set(text) {
            pathToSettingsInput.text = text
        }
}