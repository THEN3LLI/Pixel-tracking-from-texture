package dev.then3lli.grid;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import dev.then3lli.actors.Player;
import sun.awt.X11.XSystemTrayPeer;


public class Grid {



    protected Array arrayGrid;
    protected Texture texturePixmap, texture;
    protected TextureData textureData;
    protected Pixmap pixmap;

    protected Array<Vector2> blackCoordinate;

    public Array<Vector2> getWhiteCoordinate() {
        return whiteCoordinate;
    }

    public void setWhiteCoordinate(Array<Vector2> whiteCoordinate) {
        this.whiteCoordinate = whiteCoordinate;
    }

    protected Array<Vector2> whiteCoordinate;



    protected int size;





    /***
     * With a texture (black and white) given, it saves an array of 0 and 1. walkable not walkable.
     * @param texturePath
     * @param size
     */
    public Grid(String texturePath, int size){ // 0 for non walkable, 1 for walkable
        arrayGrid = new Array();
        this.size = size;
        this.texturePixmap = new Texture(Gdx.files.internal(texturePath+"Pixmap.png"));
        this.texture = new Texture(Gdx.files.internal(texturePath+".png"));
        textureData = texturePixmap.getTextureData();
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }

        pixmap = textureData.consumePixmap();
        pixmap.setBlending(Pixmap.Blending.None);

        whiteCoordinate = new Array<>();
        blackCoordinate = new Array<>();
        for(int x = 0; x<size; x++){
            for(int y = 0; y < size; y++){
                int pixel = pixmap.getPixel(x,y);
                //System.out.println(pixmap.getPixel(x,y));
                if(pixel!= 255){
                    arrayGrid.add("white");
                    whiteCoordinate.add(new Vector2(x,y));
                }
                if(pixel == 255){

                    arrayGrid.add("black");
                    blackCoordinate.add(new Vector2(x,y));
                    System.out.println(x+" "+y);
                }
            }

        }
        for(int i = 0; i< arrayGrid.size; i++){
            System.out.println(arrayGrid.get(i));
        }

    }



    public Array getArrayGrid() {
        return arrayGrid;
    }

    public void setArrayGrid(Array arrayGrid) {
        this.arrayGrid = arrayGrid;
    }

    public Texture getTexturePixmap() {
        return texturePixmap;
    }

    public void setTexturePixmap(Texture texturePixmap) {
        this.texturePixmap = texturePixmap;
    }

    public TextureData getTextureData() {
        return textureData;
    }

    public void setTextureData(TextureData textureData) {
        this.textureData = textureData;
    }

    public Pixmap getPixmap() {
        return pixmap;
    }

    public void setPixmap(Pixmap pixmap) {
        this.pixmap = pixmap;
    }
    public Array<Vector2> getBlackCoordinate() {
        return blackCoordinate;
    }
    public int getSize() {
        return size;
    }
    public void setBlackCoordinate(Array<Vector2> blackCoordinate) {
        this.blackCoordinate = blackCoordinate;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public Texture getTexture(){
        return texture;
    }

}
