package io.github.frostqui.world.tiles;

import java.util.Random;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.Tile;

public class PlantTile extends Tile{
	

	private Sprite xs_tite;
	private Sprite s_tile;
	private Sprite m_tile;
	private Sprite l_tile;
	private Sprite xl_tile;
	
	private int life;
	
	private Random random;
	
	public PlantTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public PlantTile(Sprite sprite, Sprite s_tile, Sprite m_tile, Sprite l_tile, Sprite xl_tile) {
		super(sprite);
		
		
		this.random = new Random();
		
		this.xs_tite = sprite;
		this.s_tile = s_tile;
		this.m_tile = m_tile;
		this.l_tile = l_tile;
		this.xl_tile = xl_tile;
	}
	
	public void render(Screen screen) {
		super.render(x, y, screen);
	}

	public Sprite getXs_tite() {
		return xs_tite;
	}

	public void setXs_tite(Sprite xs_tite) {
		this.xs_tite = xs_tite;
	}

	public Sprite getS_tile() {
		return s_tile;
	}

	public void setS_tile(Sprite s_tile) {
		this.s_tile = s_tile;
	}

	public Sprite getM_tile() {
		return m_tile;
	}

	public void setM_tile(Sprite m_tile) {
		this.m_tile = m_tile;
	}

	public Sprite getL_tile() {
		return l_tile;
	}

	public void setL_tile(Sprite l_tile) {
		this.l_tile = l_tile;
	}

	public Sprite getXl_tile() {
		return xl_tile;
	}

	public void setXl_tile(Sprite xl_tile) {
		this.xl_tile = xl_tile;
	}

	public void update() {
		life += random.nextInt(3);
		
		if(life > 5000) {
			this.sprite = this.s_tile;
		}
		
		System.out.println(this.life);
		
	}
	
	

}
