
package template.tool;

import processing.app.Base;
import processing.app.tools.Tool;
import processing.app.ui.Editor;

// http://blog.livedoor.jp/reona396/archives/55030723.html
// !! build.properties : path change (\\)windows
// !! processing-tool-template-x.x.x/lib <- core.jar, pde.jar copy & add to build path
// !! comment out package
// !! Before Ant build, close processing

// http://blog.livedoor.jp/reona396/archives/55030723.html
// https://sites.google.com/site/gutugutu30/tweet/processingeditorkurasutokashiifang

public class HelloTool implements Tool {	// class name = project.name (build.properties)
  Base base;

  public void init(Base base) {
    this.base = base;    			// Store a reference to the Processing application itself
  }

  public String getMenuTitle() {	// displayed with tools list
    return "##tool.name##";
  }
  
  public void run() {
    Editor editor = base.getActiveEditor();   // Get the currently active Editor to run the Tool on it

    System.out.println("Hello Tool. ##tool.name## ##tool.prettyVersion## by ##author##");	// <- build.property
    
    for (int i = 0; i < editor.getLineCount(); i++){
    	String s = editor.getLineText(i);
        System.out.println(i + " : " + s);
    }
  }  
}
