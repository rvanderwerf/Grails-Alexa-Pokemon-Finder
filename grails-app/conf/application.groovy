alexaSkills.supportedApplicationIds="amzn1.ask.skill.b349e780-c36e-4cda-83cb-38d3463c86d5"
alexaSkills.disableVerificationCheck = true // helpful for debugging or replay a command via curl
alexaSkills.serializeRequests = true // this logs the requests to disk to help you debug
alexaSkills.serializeRequestsOutputPath = "/tmp/"

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.vanderfox.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.vanderfox.UserRole'
grails.plugin.springsecurity.authority.className = 'com.vanderfox.Role'
grails.plugin.springsecurity.authority.groupAuthorityNameField = 'authorities'
grails.plugin.springsecurity.useRoleGroups = false
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/logout**', access: ['permitAll']],
		[pattern: '/register/**', access: ['permitAll']],
		//[pattern: '/logout/**', access: ['permitAll']],
		[pattern: '/registrationCode/**', access: ['permitAll']],
		[pattern: '/hello/**', access: ['permitAll']],
		[pattern: '/securityInfo/**', access: ['permitAll']],
		[pattern: '/user/**', access: ['permitAll']],
		[pattern: '/role/**', access: ['ROLE_ADMIN']],
		[pattern: '/securityInfo/**', access: ['ROLE_ADMIN']],
		[pattern: '/requestMap/**', access: ['ROLE_ADMIN']],
		[pattern: '/oauth/authorize',           access: "isFullyAuthenticated() and (request.getMethod().equals('GET') or request.getMethod().equals('POST'))"],
		[pattern: '/oauth/token',               access: "isFullyAuthenticated() and request.getMethod().equals('POST')"]
]


grails.plugin.springsecurity.filterChain.chainMap = [
		[pattern: '/assets/**',      filters: 'none'],
		[pattern: '/**/js/**',       filters: 'none'],
		[pattern: '/**/css/**',      filters: 'none'],
		[pattern: '/**/images/**',   filters: 'none'],
		[pattern: '/**/favicon.ico', filters: 'none'],
		[pattern: '/oauth/token',               filters: 'JOINED_FILTERS,-oauth2ProviderFilter,-securityContextPersistenceFilter,-logoutFilter,-authenticationProcessingFilter,-rememberMeAuthenticationFilter,-exceptionTranslationFilter'],
		[pattern: '/securedOAuth2Resources/**', filters: 'JOINED_FILTERS,-securityContextPersistenceFilter,-logoutFilter,-authenticationProcessingFilter,-rememberMeAuthenticationFilter,-oauth2BasicAuthenticationFilter,-exceptionTranslationFilter'],
		[pattern: '/**',                        filters: 'JOINED_FILTERS,-statelessSecurityContextPersistenceFilter,-oauth2ProviderFilter,-clientCredentialsTokenEndpointFilter,-oauth2BasicAuthenticationFilter,-oauth2ExceptionTranslationFilter']
]



// Added by the Spring Security OAuth2 Provider plugin:
grails.plugin.springsecurity.oauthProvider.clientLookup.className = 'com.vanderfox.Client'
grails.plugin.springsecurity.oauthProvider.authorizationCodeLookup.className = 'com.vanderfox.AuthorizationCode'
grails.plugin.springsecurity.oauthProvider.accessTokenLookup.className = 'com.vanderfox.AccessToken'
grails.plugin.springsecurity.oauthProvider.refreshTokenLookup.className = 'com.vanderfox.RefreshToken'
grails.plugin.springsecurity.ui.register.emailFrom = 'skills@vanderfox.com'
grails.plugin.springsecurity.logout.postOnly = false

mail {
	host=  ""
	port = "587"
	username= "<redacted>"
	password= "<redacted>"
	props {
		mail.smtp.auth= "true"
		mail.smtp.socketFactory.port= "587"
		mail.smtp.starttls.enable= "true"
	}

}





// Added by the Spring Security OAuth2 Provider plugin:
grails.plugin.springsecurity.oauthProvider.clientLookup.className = 'com.vanderfox.Client'
grails.plugin.springsecurity.oauthProvider.authorizationCodeLookup.className = 'com.vanderfox.AuthorizationCode'
grails.plugin.springsecurity.oauthProvider.accessTokenLookup.className = 'com.vanderfox.AccessToken'
grails.plugin.springsecurity.oauthProvider.refreshTokenLookup.className = 'com.vanderfox.RefreshToken'

