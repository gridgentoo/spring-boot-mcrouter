FROM            ubuntu:18.04

RUN             mkdir -p /etc/apt && touch /etc/apt/sources.list
RUN             apt-get update && apt-get -y install sudo wget gnupg2 autoconf
RUN             sudo wget -O - https://facebook.github.io/mcrouter/debrepo/bionic/PUBLIC.KEY |  apt-key add -
RUN             echo "deb https://facebook.github.io/mcrouter/debrepo/bionic bionic contrib" >> /etc/apt/sources.list
RUN             apt-get update && apt-get -y install mcrouter
RUN             useradd -u 8877 nobody
USER            nobody
ENTRYPOINT      ["mcrouter"]