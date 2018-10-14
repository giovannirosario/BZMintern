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




