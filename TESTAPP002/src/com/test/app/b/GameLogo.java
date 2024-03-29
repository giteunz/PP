package com.test.app.b;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;

public class GameLogo extends CCColorLayer {
	
	public static CCScene scene()
	{
		CCScene scene = CCScene.node();
		GameLogo  layer = new GameLogo (ccColor4B.ccc4(0, 255, 255, 255));
		scene.addChild(layer);
		
		return scene;
	}
	
	protected GameLogo (ccColor4B color)
	{
		super(color); 
		this.setIsTouchEnabled(true);	
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		CCLabel _label;
		
		_label = CCLabel.makeLabel("[멋있는 로고 화면]", "DroidSans", 72);
		_label.setColor(ccColor3B.ccBLACK);
		_label.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		addChild(_label);
		// FadeOut	
		_label.runAction(CCFadeOut.action(2.0f));
		// DelayTime gamelogoDone() 
		this.runAction(CCSequence.actions(CCDelayTime.action(2.0f), CCCallFunc.action(this, "gamelogoDone")));
		
		
	}
	
	public void gamelogoDone()
	{
		CCDirector.sharedDirector().replaceScene(GameMenu.scene());
	}
	
}