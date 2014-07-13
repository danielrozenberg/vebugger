Vebugger
========

A visual debugger for Eclipse.

This is a work in progress.



Tinkering
--------
1. Import the plugin project (`vebugger-eclipse-plugin`) to your Eclipse workspace and run it as an Eclipse Application
2. Inside the "inner" Eclipse, import any project that you want to tinker with, and the Vebugger Aid project (`vebugger-templates-addon`)
3. Right click on the project you want to tinker with, select Build Path > Configure Build Path, select the Projects tab and add the `vebugger-templates-addon` project
4. Debug-run the project you want to tinker with, when you reach a breakpoint right click on any variable under the Variables view, select Show Details As > Visual Debugger

To add more templates extend the VebuggerTemplate class. Your template class must be in the `vebugger.templates` package, but does not have to be inside the `vebugger-templates-addon` project.
