import org.apache.ivy.plugins.resolver.FileSystemResolver

grails.project.dependency.resolution = {
    inherits "global" // inherit Grails' default dependencies
    log "warn"

    repositories {
        grailsHome()
        grailsCentral()

        mavenCentral()
        def ulcClientJarResolver = new FileSystemResolver()
        String absolutePluginDir = grailsSettings.projectPluginsDir.absolutePath

        ulcClientJarResolver.addArtifactPattern "${absolutePluginDir}/ulc-[revision]/web-app/lib/[artifact].[ext]"
        ulcClientJarResolver.name = "ulc"

        resolver ulcClientJarResolver


        mavenRepo "https://repository.intuitive-collaboration.com/nexus/content/repositories/pillarone-public/"
    }

    String ulcVersion = "ria-suite-2013"

    plugins {
        runtime ":maven-publisher:0.7.5", {
            excludes "groovy"
        }
        compile "com.canoo:ulc:${ulcVersion}"

        test ":code-coverage:1.2.4"
    }

    dependencies {
        compile('jfree:jfreechart:1.0.12')

        //required for ulc tests
        test 'org.mortbay.jetty:jetty:6.1.21', 'org.mortbay.jetty:jetty-plus:6.1.21'
        test 'org.mortbay.jetty:jetty-util:6.1.21', 'org.mortbay.jetty:jetty-naming:6.1.21'
        test('org.mortbay.jetty:jsp-2.0:6.1.21') {
            excludes 'commons-el', 'ant', 'slf4j-api', 'slf4j-simple', 'jcl104-over-slf4j', 'xercesImpl', 'xmlParserAPIs'
        }
        test 'hsqldb:hsqldb:1.8.0.10'
    }
}

grails.project.dependency.distribution = {
    String password = ""
    String user = ""
    String scpUrl = ""
    try {
        Properties properties = new Properties()
        properties.load(new File("${userHome}/deployInfo.properties").newInputStream())

        user = properties.get("user")
        password = properties.get("password")
        scpUrl = properties.get("url")
    } catch (Throwable t) {
    }
    remoteRepository(id: "pillarone", url: scpUrl) {
        authentication username: user, password: password
    }
}

coverage {
    enabledByDefault = true
    xml = true
    exclusions = [
            'models/**',
            '**/*Test*',
            '**/com/energizedwork/grails/plugins/jodatime/**',
            '**/grails/util/**',
            '**/org/codehaus/**',
            '**/org/grails/**',
            '**GrailsPlugin**',
            '**TagLib**'
    ]

}
