package assets;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public enum Fonts {
    SATOSHI_40("src/main/java/assets/fonts/Satoshi-Variable.ttf", 40f),
    SATOSHI_20("src/main/java/assets/fonts/Satoshi-Variable.ttf", 20f),
    SATOSHI_15("src/main/java/assets/fonts/Satoshi-Variable.ttf", 15f),
    SATOSHI_10("src/main/java/assets/fonts/Satoshi-Variable.ttf", 10f);

    Font font;
    Fonts(String fontPath, float size){
        try{
            this.font = Font.createFont(Font.PLAIN, new File(fontPath)).deriveFont(size);
        } catch (IOException | FontFormatException e){
            e.printStackTrace();
        }
    }

    public Font getFont(){
        return this.font;
    }

}
