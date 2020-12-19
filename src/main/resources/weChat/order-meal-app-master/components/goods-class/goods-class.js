Component({
    /**
     * 组件的初始数据
     */
    data: {
        currentIndex: 0,
        currentItem: {}
    },
    /**
     * 组件的属性列表
     */
    properties: {
        // 从外部页面传递过来的数据 
        items: {
            type: Array,
            value: []
        }
    },
    /**
     * 组件的方法列表
     */
    methods: {
        // 获取当前点击项的index值及相关数据
        _handlerTap: function(event) {
            // console.log(event)
            // console.log(event.currentTarget.id)
            // console.log(event.currentTarget.dataset.item)
            let cid = event.currentTarget.id
            let cdata = event.currentTarget.dataset.item
            this.setData({
                currentIndex: cid
            })

            // 触发一个自定义事件，并且把数据传递出去
            this.triggerEvent("selectChange", {currentIdx: cid, currentData: cdata}, {})
        }
    }
})