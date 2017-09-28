package com.redhat.demos.openshift.fis.ws;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.redhat.fuse.demos.ws.wsmultiply.MultiplyDTO;
import com.redhat.fuse.demos.ws.wsmultiply.MultiplyResult;

public class MultiplyProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		MultiplyDTO dto = exchange.getIn().getBody(MultiplyDTO.class);
		int res = dto.getOper1()*dto.getOper2();
		MultiplyResult result = new MultiplyResult();
		result.setResult(res);
		exchange.getIn().setBody(result);
	}

}
