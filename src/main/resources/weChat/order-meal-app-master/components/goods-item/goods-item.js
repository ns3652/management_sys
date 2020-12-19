Component({
    data: {},
    properties: {
        items: {
            type: Array,
            value: []
        }
    },
    methods: {
        // 获取当前点击项的index值及相关数据
        _handlerAddCount: function (event) {
            // console.log(event)
            let item_index = event.currentTarget.id
            let item_data = event.currentTarget.dataset.item
            // this.setData({
            //     currentIndex: cid
            // })
            // 触发一个自定义事件，并且把数据传递出去
            this.triggerEvent("addCount", { item_index: item_index, item_data: item_data }, {})
        },
        // 减少数量
        _handlerMinusCount: function (event) {
            let index = event.currentTarget.id
            let data = event.currentTarget.dataset.item

            // 触发一个自定义事件，并且把数据传递出去
            this.triggerEvent("minusCount", { item_index: index, item_data: data }, {})
        }
    }
})