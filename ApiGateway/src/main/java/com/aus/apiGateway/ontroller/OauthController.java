package com.aus.apiGateway.ontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aus.apiGateway.model.AuthResponse;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/auth")
public class OauthController {

	private Logger logger=org.slf4j.LoggerFactory.getLogger(OauthController.class);
	
	@GetMapping("/login")
	public ResponseEntity<AuthResponse> login(
			@RegisteredOAuth2AuthorizedClient ("okta") OAuth2AuthorizedClient client,
			@AuthenticationPrincipal OidcUser user,Model model
			
			){
		
		logger.info("user email : {}",user.getEmail());
		AuthResponse authResponse=new AuthResponse();
		authResponse.setUserId(user.getEmail());
		authResponse.setAcessToken(client.getAccessToken().getTokenValue());
		authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
		authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
		
		List<String> collect= user.getAuthorities().stream().map(grantedAuthority-> grantedAuthority.getAuthority())
		.collect(Collectors.toList());
		
		authResponse.setAuthorities(collect);
		
		return new ResponseEntity<>(authResponse,org.springframework.http.HttpStatus.OK);
		
	}
}
