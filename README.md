# BZMintern

A partir do dataset fornecido no link
https://gist.github.com/fabiosl/bfef293c110d3513b334f4134bff8ca2/raw/cb1ff2de0899f1c9a6c11c006ba24ff56e9f0571/dataset.json

Utilizei as ferramentas
JQ https://stedolan.github.io/jq/	e
JSON PY ES https://github.com/xros/jsonpyes 

Passos
No sublime, retirei a anotação do array e as virgulas que separavam cada documento.
No terminal
(cat data.json | jq -c .) > file
para desfazer o 'pretty' e 
jsonpyes --data file --bulk http://localhost:9200 --import --index post_test --type post --check
para deixar no padrão da API bulk e upar no ES.

Após perceber que o mapping criado automaticamente havia mapeado o campo 'date' como "text", recriei o index mapeando 'date' para long.

Foi utilizada a API Java High Level REST Client fornecida por www.elastic.co e documentação completa no link:
https://snapshots.elastic.co/javadoc/org/elasticsearch/client/elasticsearch-rest-high-level-client/7.0.0-alpha1-SNAPSHOT/index.html

Utilizando essa API, foi implementado uma classe DAO (Data Acess Object) que constroi a query, executa uma search request no banco ElasticSearch e então retorna um objeto SearchHits, contendo todos os posts, comentários e replies com o nome de usuário e rede social fornecidos.

No controller da minha API, foi implementado uma rota GET /bzm_api/getPosts que recebe obrigatoriamente os QueryParams 'username' e 'social_net' e os parametros opcionais 'order' e 'limit'.


