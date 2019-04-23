# Statistics API

Projeto para contemplação de trabalho final da disciplina de microservices.

## Dockerizando a aplicação

Para que possamos realizar a configuração da imagem do container, precisamos já ter o Dockerfile da aplicação configurado.

Já com o arquivo Dockerfile configurado e dentro do diretório raiz da aplicação, digite o seguinte comando:
"docker build -f Dockerfile -t nomedaimagem ."

Após digitar o comando acima, aguarde até que a engine do docker finalize a criação da imagem com o .jar específicado no
arquivo Dockerfile e suas demais configurações.

Ao final da configuração, a sua imagem deve estar presente na lista de imagens disponíveis, você pode conferir com o
seguinte comando:
"docker images"

## Executando a aplicação

Após o processo de configuração, podemos iniciar a aplicação através de um container com a imagem criada, para isso
digite o seguinte comando:
"docker run -p 8085:8085 nomedaimagem"

Após este comando a engine do docker irá iniciar um container com a imagem da sua aplicação e com isso o serviço criado
será exposto na porta 8085, conforme específicado no comando acima.