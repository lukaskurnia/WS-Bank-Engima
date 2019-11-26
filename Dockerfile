FROM tomcat:9.0.27
MAINTAINER Borgy Manotoy <borgymanotoy@ujeaze.com>

# Update Apt and then install Nano editor (RUN can be removed)
RUN mkdir -p /usr/local/tomcat/conf

# Copy configurations (Tomcat users, Manager app)
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/webapps/manager/META-INF/
COPY target/ws-bank-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

