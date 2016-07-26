import com.vanderfox.Client
import com.vanderfox.Role

import com.vanderfox.User
import com.vanderfox.UserRole


class BootStrap {



    def init = { servletContext ->

        if (User.count() < 1) {
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

            def testUser = new User(username: "admin", password: "changeme")
            testUser.save(flush: true)

            def role1 = UserRole.create testUser, Role.findByAuthority("ROLE_ADMIN"), true
            def role2 = UserRole.create testUser, Role.findByAuthority("ROLE_USER"), true

            assert User.count() == 1
            assert Role.count() == 2
            assert UserRole.count() == 2
        }
        //assert UserRoleGroup.count() > 0

        new Client(
                clientId: 'my-client',
                authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                authorities: ['ROLE_CLIENT'],
                scopes: ['read', 'write'],
                redirectUris: ['http://myredirect.com']
        ).save(flush: true)
        //TODO make these configurable
        new Client(
                clientId: 'alexa-skill-ryan',
                authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                authorities: ['ROLE_CLIENT'],
                scopes: ['read', 'write'],
                redirectUris: ['https://pitangui.amazon.com/spa/skill/account-linking-status.html?vendorId=MX4X7ECUS4TZT','']
        ).save(flush: true)

    }
    def destroy = {
    }
}
