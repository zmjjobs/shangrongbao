import request from '@/utils/request'

export default {
  getPageList(pageIndex, pageSize, searchObj) {
    return request({
      url: `/admin/core/userInfo/listPage/${pageIndex}/${pageSize}`,
      method: 'get',
      params: searchObj,
    })
  },
}
