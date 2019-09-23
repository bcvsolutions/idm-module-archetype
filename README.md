# CzechIdM module archetype
Archetype generate basic **module skeleton** for our devstack, including backend and frontend module.

With this archetype you can easily generate app skeleton. With this folder structure:

```
./idm-<mid>/
 ├── Realization/                           ⟵ Realization folder (contains FE + BE)
 |   ├── frontend                           ⟵ frontend module
 |   |   └── czechidm-<mid>/
 |   |       ├── src                        ⟵ frontend sources
 |   |       ├── test                       ⟵ frontend tests
 |   |       ├── component-descriptor.js
 |   |       ├── module-descriptor.js
 |   |       ├── package.json
 |   |       └── routes.js
 |   └── backend                            ⟵ backend module
 |       └── idm-<mid>/
 |           ├── src                        ⟵ backend sources
 |           |   ├── main/
 |           |   └── test/
 |           └── pom.xml                    ⟵ backend pom.xml
 └── pom.xml                                ⟵ artefact pom.xml (you can remove this pom)
```

## Generate new module
This is tutorial describes step by step how to generate new module (FE+BE) for CzechIdM. This tutorial expected installed **maven**.

### Create/update your maven settings.xml

In newer maven archetype plugin isn't possible set repository with archetype directly to command. You must setup this into **settings.xml**. Open/create file **settings.xml** in your favorite editor example (linux based system):

``$ nano ~/.m2/settings.xml``

Into this file add new profile with archetype definition. Example:

```
<settings>
    ...
    <profiles>
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
      -DinteractiveMode=false \
      -DarchetypeGroupId=eu.bcvsolutions.idm \
      -DarchetypeArtifactId=idm-module-archetype \
      -DarchetypeVersion=1.1.0 \
      -DartifactId=<artefact-id> \
      -Dmid=<module-identifier> \
      -Dmn=<module-name> \
      -Dauthor=<author> \
      -Dversion=<version> \
      -DczechIdMVersion=<czechidm-version>
```
#### Parameters

| Parameter   |      Info      |      Default value      |      Required     |      You can modify     |
|----------|:-------------:|:-------------:|:-------------:|:-------------:|
| **-Pczechidm-public-repo** | Profile for connection to our nexus. Defined in **settings.xml**  | *(without value)* | ☑ | ☐ |
| **-DinteractiveMode=false**   | Skip interactive mode for generate archetyepe  | false  | ☐  | ☑  |
| **-DarchetypeGroupId** |  Archetype group id  | eu.bcvsolutions.idm  | ☑  | ☐ |
| **-DarchetypeArtifactId**  |  Archetype artefact id.  | idm-module-archetype  | ☑  | ☐ |
| **-DarchetypeVersion**   | Version of archetype  |   | ☑  | ☑ |
| **-DartifactId**   | Artefact id for your now module  | idm-dojo  | ☑  | ☑ |
| **-Dmid**   | **Identifier of your new module**. Lower case, three letters preferred. | dojo | ☑  | ☑ |
| **-Dmn**   | **Short name of your new module**. Usage of ``mid`` with the first uppercase  letter is preferred.  Three letters preferred. Used as classes prefix.  | Dojo  | ☑  | ☑ |
| **-Dauthor**   | You :)  | BCV solutions s.r.o.  |  ☑ | ☑ |
| **-Dversion**   | Version of your new module  | 1.0.0-SNAPSHOT  | ☑  | ☑ |
| **-DczechIdMVersion**   | Version for dependency on CzechIdM product.   | 9.7.7  | ☑ | ☑  |

**Full example:**

```
$ mvn archetype:generate \
      -Pczechidm-public-repo \
      -DinteractiveMode=false \
      -DarchetypeGroupId=eu.bcvsolutions.idm \
      -DarchetypeArtifactId=idm-module-archetype \
      -DarchetypeVersion=1.1.0 \
      -DartifactId=idm-dojo \
      -Dmid=dojo \
      -Dmn=Dojo \
      -Dauthor='Awesome developer' \
      -Dversion=1.0.0-SNAPSHOT \
      -DczechIdMVersion=9.7.7
```

**Minimalistic example:**

Archetype is placed in public maven repository, **Dojo** module is generated using default values.

```
$ mvn archetype:generate \
      -Pczechidm-public-repo \
      -DinteractiveMode=false \
      -DarchetypeGroupId=eu.bcvsolutions.idm \
      -DarchetypeArtifactId=idm-module-archetype \
      -DarchetypeVersion=1.1.0 \
      -DartifactId=idm-dojo \
      -Dmid=dojo \
      -Dmn=Dojo
```

### After run command

Complete build ended with this status:

``[INFO] BUILD SUCCESS``

Archetype generate frontend module as part of backend module. You can easily copy frontend folder from backend module.

In newly generated project exists unless pom.xml in root of your project, please remove this pom.xml, example:

```
./idm-<mid>/
 ├── Realization/
 |   ├── frontend
 |   └── backend
 └── pom.xml               ⟵ REMOVE THIS POM.XML
```

Example remove pom (linux based system):
``$ rm /idm-<mid>/pom.xml``

 ## License

 [MIT License](./LICENSE)

  ## TODO`s

  * Create script for generate archetype (via maven) and then remove unless pom.xml,
  * create second archetype for create app project (FE+BE).

  ## Know issues
  * now isn't possible modify groupId for your project, becouse CzechIdM application doesn't support another groupId than **eu.bcvsolutions.idm** => based on component scanning starts under this package.
