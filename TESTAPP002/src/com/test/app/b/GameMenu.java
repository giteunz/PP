package com.test.app.b;

import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.menus.CCMenuItemFont;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;

import android.util.Log;

public class GameMenu extends CCColorLayer {
	
	public static CCScene scene()
	{
		CCScene scene = CCScene.node();
		GameMenu  layer = new GameMenu (ccColor4B.ccc4(255, 0, 255, 255));
		scene.addChild(layer);
		
		return scene;
	}
	
	protected GameMenu (ccColor4B color)
	{
		super(color); 
		this.setIsTouchEnabled(true);	
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		CCLabel _label;
		
		_label = CCLabel.makeLabel("[파피루스느낌나는 메뉴 화면]", "DroidSans", 72);
		_label.setColor(ccColor3B.ccBLACK);
		_label.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		addChild(_label);
		//_label.runAction(CCFadeIn.action(1.0f));

		CCMenuItem item1;
		item1= CCMenuItemFont.item("[시작버튼임]", this, "item1Touched"); 
		item1.setScale(2.0f);
		CCMenu menu = CCMenu.menu(item1);		
		menu.setPosition(winSize.width/2, winSize.height/2-200.0f);		
		addChild(menu);
		menu.setIsTouchEnabled(true);
	}		

		
	public void item1Touched(Object sender)
	{
		Log.d("yyyy", "gooooooooo");
		CCDirector.sharedDirector().replaceScene(GamePlay.scene());
		Log.d("yyyy", "goooooooo1111111111o");
	}
	
 
}