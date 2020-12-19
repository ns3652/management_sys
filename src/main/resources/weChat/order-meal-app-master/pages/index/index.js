//index.js
//获取应用实例
const app = getApp()

Page({
    data: {
        restaurantInfo: {
            logo: 'https://tse2-mm.cn.bing.net/th/id/OIP.g01fMwo0SfIiOOasr-P8NAHaGo?w=211&h=183&c=7&o=5&dpr=2&pid=1.7',
            title: '某某医院营养餐厅',
            memo: '餐厅装修简约明快，时尚典雅，赏心悦目；为您提供绿色、有机、健康食物，传递健康的养生观念，创建和谐人文环境。',
            image:'https://tse4-mm.cn.bing.net/th/id/OIP.SryMLwWeoR-QRJ2qipImVQHaE7?w=300&h=199&c=7&o=5&dpr=2&pid=1.7',
            address: '后勤1号楼1楼营养餐厅'
        },
        busineHour: [
            {
                'mealName': '早餐',
                'orderTime': '06:00',
                'refundTime': '06:30'
            }, {
                'mealName': '午餐',
                'orderTime': '10:00',
                'refundTime': '10:30'
            }, {
                'mealName': '晚餐',
                'orderTime': '16:00',
                'refundTime': '16:30'
            }
        ]
    },
    onLoad: function() {
        
    },
    _handlerOrderClick(evt) {
        //跳转到订餐
        wx.switchTab({ url: '../foods/foods' })
    },
    getUserInfo: function(e) {
        console.log(e)
        app.globalData.userInfo = e.detail.userInfo
        this.setData({
            userInfo: e.detail.userInfo,
            hasUserInfo: true
        })
    }
})