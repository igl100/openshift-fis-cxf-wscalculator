package com.redhat.demos.openshift.fis.ws;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.fuse.demos.ws.wssum.SumDTO;
import com.redhat.fuse.demos.ws.wssum.SumResult;

public class SumProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		SumDTO dto = exchange.getIn().getBody(SumDTO.class);
		int res = dto.getOper1()+dto.getOper2();
		SumResult result = new SumResult();
		result.setResult(res);
		exchange.getIn().setBody(result);
	}

}
