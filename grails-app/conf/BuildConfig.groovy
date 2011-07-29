import org.apache.ivy.plugins.resolver.FileSystemResolver

grails.project.dependency.resolution = {
    inherits "global" // inherit Grails' default dependencies
    log "warn"

    repositories {
        grailsHome()
        grailsCentral()
    }

    def ulcClientJarResolver = new FileSystemResolver()
    String absolutePluginDir = grailsSettings.projectPluginsDir.absolutePath

    ulcClientJarResolver.addArtifactPattern "${absolutePluginDir}/ulc-[revision]/web-app/lib/[artifact].[ext]"
    ulcClientJarResolver.name = "ulc"

    resolver ulcClientJarResolver


    mavenRepo "https://build.intuitive-collaboration.com/maven/plugins/"

    String ulcVersion = "ria-suite-u2"

    plugins {
        runtime ":maven-publisher:0.7.5"
        runtime ":jetty:1.2-SNAPSHOT"
        compile "com.canoo:ulc:${ulcVersion}"

        test ":code-coverage:1.2.4"
    }

    dependencies {
        compile group: 'canoo', name: 'ulc-applet-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-base-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-base-trusted', version: ulcVersion
        compile group: 'canoo', name: 'ulc-jnlp-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-servlet-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-standalone-client', version: ulcVersion
    }
}

grails.project.dependency.distribution = {
    String passPhrase = ""
    String scpUrl = ""
    try {
        Properties properties = new Properties()
        properties.load(new File("${userHome}/deployInfo.properties").newInputStream())

        passPhrase = properties.get("passPhrase")
        scpUrl = properties.get("url")
    } catch (Throwable t) {
    }
    remoteRepository(id: "pillarone", url: scpUrl) {
        authentication username: 'root', privateKey: "${userHome.absolutePath}/.ssh/id_rsa", passphrase: passPhrase
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