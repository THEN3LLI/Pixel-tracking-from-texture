package dev.then3lli.gamestate;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import dev.then3lli.grid.Grid;

public class GridTest extends ApplicationAdapter {
    SpriteBatch batch;
    Grid grid;
    @Override
    public void create () {
        batch = new SpriteBatch();
        grid = new Grid("test",8);
    }

    @Override
    public void render () {
        ScreenUtils.clear(0, 0, 0.01F, 1);
        batch.begin();


        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();

    }
}
