package com.niuyj.jfinal;

import com.jfinal.core.Controller;

public class HelloController extends Controller {

    public void index(){
        renderText("Hello Jfinal World");
    }

}
