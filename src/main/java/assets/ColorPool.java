package assets;

import java.awt.*;

public enum ColorPool {
    BACKGROUND_GREY(Color.decode("#f8f8f8"));
    private final Color color;

    ColorPool(Color color){
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }
    
}
