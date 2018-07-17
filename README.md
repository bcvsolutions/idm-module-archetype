# Idm module archetype
Archetype generate basic skeleton application for our devstack, including backend and frontend module.

With this archetype you can easily generate app skeleton. With this folder structure:

```
./idm-<your-artefact-id>/
 ├── frontend/                          ⟵ frontend module, copy this folder anywhere you want
 |   └── czechidm-<your-artefact-id>/
 ├── src                                ⟵ backend module sources
 |   ├── main/
 |   └── test/
 └── pom.xml                            ⟵ project pom.xml
```

## Generate new module
This is tutorial describes step by step how to generate new module (FE+BE) for CzechIdM. This tutorial excepted installed **maven**.

### Create/update your maven settings.xml

In newer maven archetype plugin isn't possible set repository with archetype directly to command. You must setup this into **settings.xml**. Open/create file **settings.xml** in your favorite editor example (linux based system):

``$ nano ~/.m2/settings.xml``

Into this file add new profile with archetype definition. Example:

```
<settings>
    ...
    </profiles>
      ...
      <profile>
        <id>czechidm-public-repo</id>
        <repositories>
          <repository>
            <id>archetype</id>
            <url>https://nexus.bcvsolutions.eu/repository/maven-public-releases/</url>
            <releases><enabled>true</enabled></releases>
            <snapshots><enabled>false</enabled></snapshots>
          </repository>
        </repositories>
      </profile>
      ...
  </profiles>
  ...
</settings>

```

New profile is called czechidm-public-repo for this profile isn't needed specificy any authentization.

### Generate project via Archetype

Go to project folder where you want generate new project module. And generate project via archetype, example:

```
$ mvn archetype:generate \
      -Pczechidm-public-repo \
      -DarchetypeGroupId=eu.bcvsolutions.idm \
      -DarchetypeArtifactId=idm-module-archetype \
      -DarchetypeVersion=1.0.0 \
      -DartifactId=<artefact-id> \
      -DmoduleName=<module-name> \
      -DgroupId=<module-group-id> \
      -Dauthor=<author> \
      -Dversion=<version> \
      -DczechIdMVersion=<czechidm-version>
```
#### Parameters

| Parameter   |      Info      |      Default value      |      Required     |      You can modify     |
|----------|:-------------:|:-------------:|:-------------:|:-------------:|
| **-Pczechidm-public-repo** | profile for connection to our nexus. Defined in **settings.xml**  | *(without value)* | ☑ | ☐ |
| **-DarchetypeGroupId** |  archetype group id  | eu.bcvsolutions.idm  | ☑  | ☐ |
| **-DarchetypeArtifactId**  |  archetype artefact id.  | idm-module-archetype  | ☑  | ☐ |
| **-DarchetypeVersion**   | version of archetype  |   | ☑  | ☑ |
| **-DartifactId**   | artefact id for your now module  | idm-example  | ☑  | ☑ |
| **-DmoduleName**   | name of your new module. Firts letter must be uppercase  | Example  | ☑  | ☑ |
| **-DgroupId**   | group id of your new module  | eu.bcvsolutions.idm  | ☑  | ☑ |
| **-Dauthor**   | You :)  | example  |  ☑ | ☑ |
| **-Dversion**   | version of your new module  | 1.0.0-SNAPSHOT  | ☑  | ☑ |
| **-DczechIdMVersion**   | version for dependency on CzechIdM product   | 8.1.3  | ☑ | ☑  |

**Full example:**

```
$ mvn archetype:generate \
      -Pczechidm-public-repo \
      -DarchetypeGroupId=eu.bcvsolutions.idm \
      -DarchetypeArtifactId=idm-module-archetype \
      -DarchetypeVersion=1.0.0 \
      -DartifactId=idm-dojo \
      -DmoduleName=Dojo \
      -DgroupId=eu.bcvsolutions.idm \
      -Dauthor='John Doe' \
      -Dversion=1.0.0-SNAPSHOT \
      -DczechIdMVersion=8.1.3
```

### After run command

After you execute generate command, maven archetype shows to you some information about progress. First you needed interact is

``Define value for property 'moduleNameLower' ${moduleName.toLowerCase()}: : █``

Please there dont modify input and just press enter.

Next step is only informative, maven archetype plugin shows to you last check before generate new module. For example:

```
Confirm properties configuration:
groupId: eu.bcvsolutions.idm
artifactId: idm-dojo
version: 1.0.0-SNAPSHOT
package: eu.bcvsolutions.idm
author: John Doe
czechIdMVersion: 8.1.3
moduleName: Dojo
moduleNameLower: ${moduleName.toLowerCase()}
 Y: : █
```

After check plese press enter.

Complete build ended with this status:

``[INFO] BUILD SUCCESS``

Archetype generate frontend module as part of backend module. You can easily copy frontend folder from backend module.

 ## License

 [MIT License](./LICENSE)
