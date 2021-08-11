package com.github.goldsubmarine.restfulhelper.services

import com.intellij.openapi.project.Project
import com.github.goldsubmarine.restfulhelper.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
