
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DriveDriveManager from "./components/listers/DriveDriveCards"
import DriveDriveDetail from "./components/listers/DriveDriveDetail"

import VideoProcessingVideoManager from "./components/listers/VideoProcessingVideoCards"
import VideoProcessingVideoDetail from "./components/listers/VideoProcessingVideoDetail"

import IndexerIndexManager from "./components/listers/IndexerIndexCards"
import IndexerIndexDetail from "./components/listers/IndexerIndexDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/drives/drives',
                name: 'DriveDriveManager',
                component: DriveDriveManager
            },
            {
                path: '/drives/drives/:id',
                name: 'DriveDriveDetail',
                component: DriveDriveDetail
            },

            {
                path: '/videoProcessings/videos',
                name: 'VideoProcessingVideoManager',
                component: VideoProcessingVideoManager
            },
            {
                path: '/videoProcessings/videos/:id',
                name: 'VideoProcessingVideoDetail',
                component: VideoProcessingVideoDetail
            },

            {
                path: '/indexers/indices',
                name: 'IndexerIndexManager',
                component: IndexerIndexManager
            },
            {
                path: '/indexers/indices/:id',
                name: 'IndexerIndexDetail',
                component: IndexerIndexDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },




    ]
})
