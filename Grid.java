package dev.then3lli.grid;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.Array;



public class Grid {

    private Array arrayGrid;
    private Texture texturePixmap;
    private TextureData textureData;
    private Pixmap pixmap;

    /***
     * With a texture (black and white) given, it saves an array of 0 and 1. walkable not walkable.
     * @param texturePath
     * @param size
     */
    public Grid(String texturePath, int size){ // 0 for non walkable, 1 for walkable
        arrayGrid = new Array();

        this.texturePixmap = new Texture(Gdx.files.internal(texturePath+"Pixmap.png"));

        textureData = texturePixmap.getTextureData();
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        pixmap = textureData.consumePixmap();
        pixmap.setBlending(Pixmap.Blending.None);

        for(int x = 0; x<size; x++){
            for(int y = 0; y < size; y++){
                int pixel = pixmap.getPixel(x,y);
                //System.out.println(pixmap.getPixel(x,y));
                if(pixel!= 255){
                    arrayGrid.add("white");
                }
                if(pixel == 255){

                    arrayGrid.add("black");
                }
            }

        }
        for(int i = 0; i< arrayGrid.size; i++){
            System.out.println(arrayGrid.get(i));
        }

    }




}
