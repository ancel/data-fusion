package com.work.data_fusion;

import com.work.data_fusion.service.FusionService;

public class AppTool {
	public boolean run(String[] args){
		FusionService fusionService = new FusionService();
		return fusionService.fuse();
	}
}
