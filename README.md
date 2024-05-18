Usando o Java acima da versão 9 deve-se adicionar as dependências abaixo no POM.XML

As dependências abaixo corrigem o erro no console de falta de biblioteca que foi retirada do Java.

Erro: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException


?

<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>9.2-1003-jdbc4</version>
		</dependency>


		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.2.6.Final</version>
		</dependency>


		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>5.2.6.Final</version>
		</dependency>


		<dependency>
			<groupid>javax.xml.bind</groupid>
			<artifactid>jaxb-api</artifactid>
			<version>2.2.11</version>
		</dependency>
		<dependency>
			<groupid>com.sun.xml.bind</groupid>
			<artifactid>jaxb-core</artifactid>
			<version>2.2.11</version>
		</dependency>
		<dependency>
			<groupid>com.sun.xml.bind</groupid>
			<artifactid>jaxb-impl</artifactid>
			<version>2.2.11</version>
		</dependency>
