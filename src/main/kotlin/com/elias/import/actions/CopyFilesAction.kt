package com.elias.import.actions

import com.elias.import.settings.ApplicationSettingsState
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformCoreDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import java.util.concurrent.TimeUnit

class CopyFilesAction(): AnAction() {
    private var applicationSettingsState = ApplicationSettingsState.instance;
    override fun actionPerformed(e: AnActionEvent) {
        val file =  File(applicationSettingsState.pathToFiles);
        file.copyRecursively(File(e.project?.basePath + "/.idea"), true);
        VfsUtil.markDirtyAndRefresh(false, true, true, e.getData(PlatformCoreDataKeys.VIRTUAL_FILE));
    }
}