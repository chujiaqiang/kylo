#!/bin/bash

###
# #%L
# kylo-catalog-credential-vault
# %%
# Copyright (C) 2017 - 2018 ThinkBig Analytics, a Teradata Company
# %%
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#     http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# #L%
###

echo "###########################################################################"
echo "# Start Vault on https://localhost:8200 and http://localhost:8201         #"
echo "###########################################################################"

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
VAULT_BIN="${DIR}/vault/vault"

${VAULT_BIN} server \
            -config=${DIR}/vault.conf \
            -dev \
            -dev-root-token-id="00000000-0000-0000-0000-000000000000" \
            -dev-listen-address="0.0.0.0:8201"

exit $?
