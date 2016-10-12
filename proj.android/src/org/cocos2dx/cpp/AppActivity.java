/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package org.cocos2dx.cpp;

import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxHelper;

import android.app.Activity;
import android.os.Bundle;

import com.jirbo.adcolony.AdColony;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAd;
import com.jirbo.adcolony.AdColonyAdListener;
import com.jirbo.adcolony.AdColonyV4VCAd;
import com.jirbo.adcolony.AdColonyV4VCListener;
import com.jirbo.adcolony.AdColonyV4VCReward;
import com.jirbo.adcolony.AdColonyAdAvailabilityListener;

public class AppActivity extends Cocos2dxActivity implements AdColonyAdAvailabilityListener, AdColonyV4VCListener, AdColonyAdListener {
	//private static final String APP_ID    = "appf8474812674b4a4a82";
    private static final String ZONE_ID   = "vz7e26648c664646809a";
    private static final String C_OPTIONS = "version:1.0,store:google";
    private static final String APP_ID    = "appf8474812674b4a4a82";
    private static boolean isReady = false;
    
    protected static Activity mActivity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }
    
    public static void initVideoAd() {

        AdColony.configure(mActivity, C_OPTIONS, APP_ID, ZONE_ID);

        AdColony.addV4VCListener(new AdColonyV4VCListener() {
            public void onAdColonyV4VCReward(AdColonyV4VCReward reward) {
                if(reward.success()) {
                }
            }
        });
        AdColony.addAdAvailabilityListener(new AdColonyAdAvailabilityListener() {
            @Override
            public void onAdColonyAdAvailabilityChange(boolean res, String zoneId) {
            	/*// コメント
                if (zoneId.equals(ZONE_ID)) {
                    isReady = res;
                }
                */
            }
        });
    }
    
    public static void playVideoAd() {
        AdColonyV4VCAd ad = new AdColonyV4VCAd(ZONE_ID);
        ad.show();
    }

	@Override
	public void onAdColonyAdAttemptFinished(AdColonyAd arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdColonyAdStarted(AdColonyAd arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdColonyV4VCReward(AdColonyV4VCReward arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAdColonyAdAvailabilityChange(boolean arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
}
