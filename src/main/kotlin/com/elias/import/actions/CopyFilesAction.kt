package com.elias.import.actions

import com.elias.import.settings.ApplicationSettingsState
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.VfsUtil
import kotlin.io.path.Path

class CopyFilesAction(): AnAction() {
    private var applicationSettingsState = ApplicationSettingsState.instance;
    override fun actionPerformed(e: AnActionEvent) {
        val settingsFiles = VfsUtil.findFile(Path(applicationSettingsState.pathToFiles), true);
        val ideaLocation = VfsUtil.findFile(Path(e.project!!.basePath + "/.idea"), true);
        val application = ApplicationManager.getApplication();
        application.runWriteAction {
            VfsUtil.copyDirectory(null, settingsFiles!!, ideaLocation!!, null);
        }
    }
}