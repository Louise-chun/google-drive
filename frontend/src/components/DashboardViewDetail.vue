<template>

    <v-card outlined>
        <v-card-title>
            Dashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Fileid" v-model="item.fileid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Filesize" v-model="item.filesize" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Filename" v-model="item.filename" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UndexYn" v-model="item.undexYn" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UploadYn" v-model="item.uploadYn" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VideoUrl" v-model="item.videoUrl" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="UploadDt" v-model="item.uploadDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Userid" v-model="item.userid" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

